@Test public void variableUnescaped() throws Exception {
  assertEquals("+-+&test-+-",compile("{{=+-+ -+-=}}+-+&test-+-").text());
}
