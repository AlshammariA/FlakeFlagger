@Test(expected=IOException.class) public void testWildcardInexistentResources() throws IOException {
  victim.locate(createUri("/css/**.NOTEXIST"));
}
