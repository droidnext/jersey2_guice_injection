package com.example.apps.application;

import org.glassfish.hk2.api.ServiceLocator;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spi.Container;
import org.glassfish.jersey.server.spi.ContainerLifecycleListener;
import org.jvnet.hk2.guice.bridge.api.GuiceBridge;
import org.jvnet.hk2.guice.bridge.api.GuiceIntoHK2Bridge;

import com.example.apps.config.SampleModule;
import com.example.apps.resources.SampleResource;
import com.google.inject.Guice;
import com.google.inject.servlet.ServletModule;



public class MyApplication extends ResourceConfig {
	
	ServiceLocator serviceLocator;
	
	public MyApplication() {
		
		super(SampleResource.class);//All all your resources 
		register(new ContainerLifecycleListener()
        {
            public void onStartup(Container container)
            {
                // access the ServiceLocator here
                serviceLocator = container.getApplicationHandler().getServiceLocator();

                init(serviceLocator);
            }

            public void onReload(Container container) {/*...*/}
            public void onShutdown(Container container) {/*...*/}
        });
	}

    public void init(ServiceLocator serviceLocator) {

        GuiceBridge.getGuiceBridge().initializeGuiceBridge(serviceLocator);

        GuiceIntoHK2Bridge guiceBridge = serviceLocator.getService(GuiceIntoHK2Bridge.class);
        guiceBridge.bridgeGuiceInjector(Guice.createInjector( new ServletModule() {
			 @Override
			 protected void configureServlets() {
				 install(new SampleModule());// Add all your dependent modules for injection
			 }
		 }));
    }
}