@Test(expected=IOException.class) public void shouldNotAcceptNullRequestOrResponse() throws Exception {
  victim.getInputStream(null,null,null);
}
