@Test public void mostBasic() throws IOException {
  shouldCompileTo("{{foo}}","{foo: foo}","foo");
}
