@Test public void partial() throws Exception {
  assertEquals("^^>test%%",compile("{{=^^ %%=}}^^>test%%",$(),$("test","")).text());
}
