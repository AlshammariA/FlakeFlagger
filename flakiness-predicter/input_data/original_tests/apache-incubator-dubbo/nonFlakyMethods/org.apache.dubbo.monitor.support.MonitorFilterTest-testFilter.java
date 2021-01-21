@Test public void testFilter() throws Exception {
  MonitorFilter monitorFilter=new MonitorFilter();
  monitorFilter.setMonitorFactory(monitorFactory);
  Invocation invocation=new RpcInvocation("aaa",new Class<?>[0],new Object[0]);
  RpcContext.getContext().setRemoteAddress(NetUtils.getLocalHost(),20880).setLocalAddress(NetUtils.getLocalHost(),2345);
  monitorFilter.invoke(serviceInvoker,invocation);
  while (lastStatistics == null) {
    Thread.sleep(10);
  }
  Assert.assertEquals("abc",lastStatistics.getParameter(MonitorService.APPLICATION));
  Assert.assertEquals(MonitorService.class.getName(),lastStatistics.getParameter(MonitorService.INTERFACE));
  Assert.assertEquals("aaa",lastStatistics.getParameter(MonitorService.METHOD));
  Assert.assertEquals(NetUtils.getLocalHost() + ":20880",lastStatistics.getParameter(MonitorService.PROVIDER));
  Assert.assertEquals(NetUtils.getLocalHost(),lastStatistics.getAddress());
  Assert.assertEquals(null,lastStatistics.getParameter(MonitorService.CONSUMER));
  Assert.assertEquals(1,lastStatistics.getParameter(MonitorService.SUCCESS,0));
  Assert.assertEquals(0,lastStatistics.getParameter(MonitorService.FAILURE,0));
  Assert.assertEquals(1,lastStatistics.getParameter(MonitorService.CONCURRENT,0));
  Assert.assertEquals(invocation,lastInvocation);
}
