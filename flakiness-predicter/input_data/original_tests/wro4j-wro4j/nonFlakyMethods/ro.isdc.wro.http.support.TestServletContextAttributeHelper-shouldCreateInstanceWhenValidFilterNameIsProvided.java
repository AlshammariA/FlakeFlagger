@Test public void shouldCreateInstanceWhenValidFilterNameIsProvided(){
  final String filterName="name";
  Mockito.when(mockFilterConfig.getInitParameter(ServletContextAttributeHelper.INIT_PARAM_NAME)).thenReturn(filterName);
  victim=ServletContextAttributeHelper.create(mockFilterConfig);
  Assert.assertEquals(filterName,victim.getName());
}
