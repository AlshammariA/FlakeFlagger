@Test public void shouldHaveMinimizeEnabledByDefault(){
  assertEquals(true,Context.get().getConfig().isMinimizeEnabled());
}
