@Test(expected=LinterException.class) public void shouldNotAcceptBadOptions() throws Exception {
  jsHint.setOptions("1","2");
  jsHint.validate("");
}
