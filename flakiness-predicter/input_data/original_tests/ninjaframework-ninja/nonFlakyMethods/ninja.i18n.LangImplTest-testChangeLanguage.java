@Test public void testChangeLanguage(){
  Cookie cookie=Cookie.builder("NINJA_TEST" + NinjaConstant.LANG_COOKIE_SUFFIX,"de").build();
  when(ninjaProperties.getOrDie(NinjaConstant.applicationCookiePrefix)).thenReturn("NINJA_TEST");
  Lang lang=new LangImpl(ninjaProperties);
  Result result=Results.noContent();
  result=lang.setLanguage("to",result);
  assertEquals("to",result.getCookie(cookie.getName()).getValue());
  assertEquals(Result.SC_204_NO_CONTENT,result.getStatusCode());
}
