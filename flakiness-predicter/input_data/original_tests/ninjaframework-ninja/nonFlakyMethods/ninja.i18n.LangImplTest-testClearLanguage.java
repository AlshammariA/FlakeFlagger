@Test public void testClearLanguage(){
  Cookie cookie=Cookie.builder("NINJA_TEST" + NinjaConstant.LANG_COOKIE_SUFFIX,"de").build();
  when(ninjaProperties.getOrDie(NinjaConstant.applicationCookiePrefix)).thenReturn("NINJA_TEST");
  Lang lang=new LangImpl(ninjaProperties);
  Result result=Results.ok();
  lang.clearLanguage(result);
  Cookie returnCookie=result.getCookie(cookie.getName());
  assertEquals("",returnCookie.getValue());
  assertEquals(0,returnCookie.getMaxAge());
}
