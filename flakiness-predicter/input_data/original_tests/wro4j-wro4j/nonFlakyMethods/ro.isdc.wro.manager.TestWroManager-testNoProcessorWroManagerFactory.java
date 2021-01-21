@Test public void testNoProcessorWroManagerFactory() throws IOException {
  final WroManagerFactory factory=new NoProcessorsWroManagerFactory().setModelFactory(getValidModelFactory());
  final HttpServletRequest request=Mockito.mock(HttpServletRequest.class);
  final HttpServletResponse response=Context.get().getResponse();
  final ByteArrayOutputStream out=new ByteArrayOutputStream();
  Mockito.when(response.getOutputStream()).thenReturn(new DelegatingServletOutputStream(out));
  Mockito.when(request.getRequestURI()).thenReturn("/app/g1.css");
  Context.set(Context.webContext(request,response,Mockito.mock(FilterConfig.class)));
  factory.create().process();
  WroTestUtils.compare(WroTestUtils.getInputStream("classpath:ro/isdc/wro/manager/noProcessorsResult.css"),new ByteArrayInputStream(out.toByteArray()));
}
