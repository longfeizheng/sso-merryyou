package cn.merryyou.sso.controller;

import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.security.oauth2.common.util.RandomValueStringGenerator;
import org.springframework.util.PropertyPlaceholderHelper;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created on 2018/1/26 0026.
 *
 * @author zlf
 * @email i@merryyou.cn
 * @since 1.0
 */
public class SsoSpelView implements View {

    private final String template;

    private final String prefix;

    private final SpelExpressionParser parser = new SpelExpressionParser();

    private final StandardEvaluationContext context = new StandardEvaluationContext();

    private PropertyPlaceholderHelper.PlaceholderResolver resolver;

    public SsoSpelView(String template) {
        this.template = template;
        this.prefix = new RandomValueStringGenerator().generate() + "{";
        this.context.addPropertyAccessor(new MapAccessor());
        this.resolver = new PropertyPlaceholderHelper.PlaceholderResolver() {
            public String resolvePlaceholder(String name) {
                Expression expression = parser.parseExpression(name);
                Object value = expression.getValue(context);
                return value == null ? null : value.toString();
            }
        };
    }

    public String getContentType() {
        return "text/html";
    }

    public void render(Map<String, ?> model, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        Map<String, Object> map = new HashMap<String, Object>(model);
        String path = ServletUriComponentsBuilder.fromContextPath(request).build()
                .getPath();
        map.put("path", (Object) path==null ? "" : path);
        context.setRootObject(map);
        String maskedTemplate = template.replace("${", prefix);
        PropertyPlaceholderHelper helper = new PropertyPlaceholderHelper(prefix, "}");
        String result = helper.replacePlaceholders(maskedTemplate, resolver);
        result = result.replace(prefix, "${");
        response.setContentType(getContentType());
        response.getWriter().append(result);
    }
}
