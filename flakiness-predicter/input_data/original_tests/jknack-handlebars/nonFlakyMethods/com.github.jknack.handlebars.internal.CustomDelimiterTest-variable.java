@Test public void variable() throws Exception {
  assertEquals("+-+test-+-",compile("{{=+-+ -+-=}}+-+test-+-").text());
}
