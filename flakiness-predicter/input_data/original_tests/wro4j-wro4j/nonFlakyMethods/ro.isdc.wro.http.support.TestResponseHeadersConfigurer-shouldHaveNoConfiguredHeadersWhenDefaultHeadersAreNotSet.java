@Test public void shouldHaveNoConfiguredHeadersWhenDefaultHeadersAreNotSet(){
  victim=ResponseHeadersConfigurer.emptyHeaders();
  assertTrue(victim.getHeadersMap().entrySet().isEmpty());
}
