@Test(expected=WroRuntimeException.class) public void shouldNotProcessGroupWithNoResources() throws Exception {
  final HttpServletRequest request=Mockito.mock(HttpServletRequest.class);
  final HttpServletResponse response=Context.get().getResponse();
  Mockito.when(request.getRequestURI()).thenReturn("/noResources.css");
  final WroConfiguration config=new WroConfiguration();
  config.setIgnoreEmptyGroup(false);
  Context.set(Context.webContext(request,response,Mockito.mock(FilterConfig.class)),config);
  final WroModel model=new WroModel();
  model.addGroup(new Group("noResources"));
  WroManagerFactory managerFactory=new BaseWroManagerFactory().setModelFactory(WroUtil.factoryFor(model));
  managerFactory=managerFactory;
  managerFactory.create().process();
}
