@Test public void tripleVariable() throws Exception {
  assertEquals("+-+{test}-+-",compile("{{=+-+ -+-=}}+-+{test}-+-").text());
}
