@Test public void testIsLanguageDirectlySupportedByThisApplication(){
  when(ninjaProperties.getOrDie(NinjaConstant.applicationCookiePrefix)).thenReturn("NINJA_TEST");
  when(ninjaProperties.get(NinjaConstant.applicationLanguages)).thenReturn("en");
  Lang lang=new LangImpl(ninjaProperties);
  assertTrue(lang.isLanguageDirectlySupportedByThisApplication("en"));
  assertFalse(lang.isLanguageDirectlySupportedByThisApplication("de"));
  when(ninjaProperties.get(NinjaConstant.applicationLanguages)).thenReturn("en, de, se");
  assertTrue(lang.isLanguageDirectlySupportedByThisApplication("en"));
  assertTrue(lang.isLanguageDirectlySupportedByThisApplication("de"));
  assertTrue(lang.isLanguageDirectlySupportedByThisApplication("se"));
  assertFalse(lang.isLanguageDirectlySupportedByThisApplication("tk"));
}
