@Test public void unorderedServletContextInitializerBeans() throws Exception {
  addEmbeddedServletContainerFactoryBean();
  ServletContextInitializer initializer1=mock(ServletContextInitializer.class);
  ServletContextInitializer initializer2=mock(ServletContextInitializer.class);
  this.context.registerBeanDefinition("initializerBean2",beanDefinition(initializer2));
  this.context.registerBeanDefinition("initializerBean1",beanDefinition(initializer1));
  this.context.refresh();
  ServletContext servletContext=getEmbeddedServletContainerFactory().getServletContext();
  verify(initializer1).onStartup(servletContext);
  verify(initializer2).onStartup(servletContext);
}
