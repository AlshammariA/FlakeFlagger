@Test public void multipleServletBeansWithMainDispatcher() throws Exception {
  addEmbeddedServletContainerFactoryBean();
  Servlet servlet1=mock(Servlet.class,withSettings().extraInterfaces(Ordered.class));
  given(((Ordered)servlet1).getOrder()).willReturn(1);
  Servlet servlet2=mock(Servlet.class,withSettings().extraInterfaces(Ordered.class));
  given(((Ordered)servlet2).getOrder()).willReturn(2);
  this.context.registerBeanDefinition("servletBean2",beanDefinition(servlet2));
  this.context.registerBeanDefinition("dispatcherServlet",beanDefinition(servlet1));
  this.context.refresh();
  MockEmbeddedServletContainerFactory escf=getEmbeddedServletContainerFactory();
  ServletContext servletContext=escf.getServletContext();
  InOrder ordered=inOrder(servletContext);
  ordered.verify(servletContext).addServlet("dispatcherServlet",servlet1);
  ordered.verify(servletContext).addServlet("servletBean2",servlet2);
  verify(escf.getRegisteredServlet(0).getRegistration()).addMapping("/");
  verify(escf.getRegisteredServlet(1).getRegistration()).addMapping("/servletBean2/");
}
