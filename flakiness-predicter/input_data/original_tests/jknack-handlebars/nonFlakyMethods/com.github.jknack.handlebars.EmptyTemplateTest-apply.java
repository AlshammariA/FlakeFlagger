@Test public void apply() throws IOException {
  assertEquals("",Template.EMPTY.apply((Object)null));
  assertEquals("",Template.EMPTY.apply((Context)null));
}
