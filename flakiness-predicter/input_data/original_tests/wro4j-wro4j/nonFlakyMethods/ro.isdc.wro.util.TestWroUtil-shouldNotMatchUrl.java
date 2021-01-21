@Test public void shouldNotMatchUrl(){
  final HttpServletRequest request=Mockito.mock(HttpServletRequest.class);
  Mockito.when(request.getRequestURI()).thenReturn("someresource.css");
  assertFalse(WroUtil.matchesUrl(request,"wroApi/test"));
}
