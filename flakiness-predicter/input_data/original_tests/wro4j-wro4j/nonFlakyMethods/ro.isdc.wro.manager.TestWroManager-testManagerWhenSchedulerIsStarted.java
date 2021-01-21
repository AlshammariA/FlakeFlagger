/** 
 * Test how manager behaves when the update period value is greater than zero and the scheduler starts.
 * @throws Exception
 */
@Test public void testManagerWhenSchedulerIsStarted() throws Exception {
  newConfigWithUpdatePeriodValue(1);
  final HttpServletRequest request=Mockito.mock(HttpServletRequest.class);
  final HttpServletResponse response=Context.get().getResponse();
  Mockito.when(request.getRequestURI()).thenReturn("/app/g1.css");
  Context.set(Context.webContext(request,response,Mockito.mock(FilterConfig.class)));
  managerFactory.create().process();
  Thread.sleep(500);
}
