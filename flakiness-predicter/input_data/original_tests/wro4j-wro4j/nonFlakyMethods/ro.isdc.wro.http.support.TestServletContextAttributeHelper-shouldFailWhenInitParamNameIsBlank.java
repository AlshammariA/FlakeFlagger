@Test(expected=IllegalArgumentException.class) public void shouldFailWhenInitParamNameIsBlank(){
  Mockito.when(mockFilterConfig.getInitParameter(ServletContextAttributeHelper.INIT_PARAM_NAME)).thenReturn("  ");
  victim=ServletContextAttributeHelper.create(mockFilterConfig);
}
