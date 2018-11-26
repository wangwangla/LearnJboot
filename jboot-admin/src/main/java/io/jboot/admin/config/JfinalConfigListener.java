package io.jboot.admin.config;

import com.google.inject.Binder;
import com.jfinal.config.Constants;
import com.jfinal.config.Interceptors;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.json.JFinalJsonFactory;
import com.jfinal.template.Engine;
import io.jboot.Jboot;
import io.jboot.admin.base.common.AppInfo;
import io.jboot.aop.jfinal.JfinalHandlers;
import io.jboot.aop.jfinal.JfinalPlugins;
import io.jboot.server.ContextListeners;
import io.jboot.server.JbootServer;
import io.jboot.server.Servlets;
import io.jboot.server.listener.JbootAppListenerBase;

/**
 * jfinal config
 * @author Rlax
 *
 */
public class JfinalConfigListener extends JbootAppListenerBase {
    /*定义错误也的路径*/
    @Override
    public void onJfinalConstantConfig(Constants constants) {
        constants.setError401View("/template/401.html");
        constants.setError403View("/template/403.html");
        constants.setError404View("/template/404.html");
        constants.setError500View("/template/500.html");
        constants.setJsonFactory(new JFinalJsonFactory());
    }

    @Override
    public void onJfinalRouteConfig(Routes routes) {
        routes.setBaseViewPath("/template");
    }

    @Override
    public void onJfinalEngineConfig(Engine engine) {
        engine.setDevMode(true);
        AppInfo app = Jboot.config(AppInfo.class);
        engine.addSharedObject("APP", app);
        engine.addSharedObject("RESOURCE_HOST", app.getResourceHost());
    }

    @Override
    public void onInterceptorConfig(Interceptors interceptors) {

    }

    @Override
    public void onJfinalPluginConfig(JfinalPlugins plugins) {

    }

    @Override
    public void onHandlerConfig(JfinalHandlers handlers) {
        handlers.add(new ContextPathHandler("ctxPath"));
    }

    @Override
    public void onJFinalStarted() {
    }

    @Override
    public void onJFinalStop() {
    }

    @Override
    public void onJbootStarted() {
        /** 集群模式下验证码使用 redis 缓存 */
//        CaptchaManager.me().setCaptchaCache(new CaptchaCache());
    }

    @Override
    public void onAppStartBefore(JbootServer jbootServer) {

    }

    @Override
    public void onJbootDeploy(Servlets servlets, ContextListeners listeners) {

    }

    @Override
    public void onGuiceConfigure(Binder binder) {

    }
}
