@Test public void startupWithSpecifiedValues() throws Exception {
  ServletRegistrationBean bean=new ServletRegistrationBean();
  bean.setName("test");
  bean.setServlet(this.servlet);
  bean.setAsyncSupported(false);
  bean.setInitParameters(Collections.singletonMap("a","b"));
  bean.addInitParameter("c","d");
  bean.setUrlMappings(new LinkedHashSet<String>(Arrays.asList("/a","/b")));
  bean.addUrlMappings("/c");
  bean.setLoadOnStartup(10);
  bean.onStartup(this.servletContext);
  verify(this.servletContext).addServlet("test",this.servlet);
  verify(this.registration).setAsyncSupported(false);
  Map<String,String> expectedInitParameters=new HashMap<String,String>();
  expectedInitParameters.put("a","b");
  expectedInitParameters.put("c","d");
  verify(this.registration).setInitParameters(expectedInitParameters);
  verify(this.registration).addMapping("/a","/b","/c");
  verify(this.registration).setLoadOnStartup(10);
}
