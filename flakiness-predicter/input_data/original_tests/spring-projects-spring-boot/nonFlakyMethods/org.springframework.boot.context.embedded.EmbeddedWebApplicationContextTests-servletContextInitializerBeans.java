@Test public void servletContextInitializerBeans() throws Exception {
  addEmbeddedServletContainerFactoryBean();
  ServletContextInitializer initializer1=mock(ServletContextInitializer.class,withSettings().extraInterfaces(Ordered.class));
  given(((Ordered)initializer1).getOrder()).willReturn(1);
  ServletContextInitializer initializer2=mock(ServletContextInitializer.class,withSettings().extraInterfaces(Ordered.class));
  given(((Ordered)initializer2).getOrder()).willReturn(2);
  this.context.registerBeanDefinition("initializerBean2",beanDefinition(initializer2));
  this.context.registerBeanDefinition("initializerBean1",beanDefinition(initializer1));
  this.context.refresh();
  ServletContext servletContext=getEmbeddedServletContainerFactory().getServletContext();
  InOrder ordered=inOrder(initializer1,initializer2);
  ordered.verify(initializer1).onStartup(servletContext);
  ordered.verify(initializer2).onStartup(servletContext);
}
