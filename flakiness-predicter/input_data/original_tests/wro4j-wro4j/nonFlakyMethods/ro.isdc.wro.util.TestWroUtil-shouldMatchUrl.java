@Test public void shouldMatchUrl(){
  final HttpServletRequest request=Mockito.mock(HttpServletRequest.class);
  Mockito.when(request.getRequestURI()).thenReturn("wroApi/test");
  assertTrue(WroUtil.matchesUrl(request,"wroApi/test"));
}
