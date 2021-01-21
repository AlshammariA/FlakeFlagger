@Test public void shouldUseDefaultNameWhenInitParamNameIsNull(){
  Mockito.when(mockFilterConfig.getInitParameter(ServletContextAttributeHelper.INIT_PARAM_NAME)).thenReturn(null);
  victim=ServletContextAttributeHelper.create(mockFilterConfig);
  Assert.assertEquals(ServletContextAttributeHelper.DEFAULT_NAME,victim.getName());
}
