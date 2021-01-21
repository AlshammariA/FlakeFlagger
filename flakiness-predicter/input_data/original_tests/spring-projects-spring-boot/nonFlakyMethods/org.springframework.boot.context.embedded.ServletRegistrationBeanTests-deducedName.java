@Test public void deducedName() throws Exception {
  ServletRegistrationBean bean=new ServletRegistrationBean();
  bean.setServlet(this.servlet);
  bean.onStartup(this.servletContext);
  verify(this.servletContext).addServlet("mockServlet",this.servlet);
}
