@Test public void canSetNullOptions() throws Exception {
  victim.setOptionsAsString("");
  victim.process(null,new StringReader("alert(1);"),new StringWriter());
}
