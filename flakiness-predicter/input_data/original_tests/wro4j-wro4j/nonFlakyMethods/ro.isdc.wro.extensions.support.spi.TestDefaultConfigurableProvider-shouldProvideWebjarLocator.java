@Test public void shouldProvideWebjarLocator(){
  assertTrue(victim.provideLocators().containsKey(WebjarUriLocator.ALIAS));
}
