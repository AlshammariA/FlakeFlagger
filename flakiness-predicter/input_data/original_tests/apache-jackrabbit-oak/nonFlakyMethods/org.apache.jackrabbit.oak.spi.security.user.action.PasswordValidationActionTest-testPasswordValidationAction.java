@Test public void testPasswordValidationAction() throws Exception {
  List<String> invalid=new ArrayList<String>();
  invalid.add("pw1");
  invalid.add("only6C");
  invalid.add("12345678");
  invalid.add("WITHOUTLOWERCASE");
  invalid.add("withoutuppercase");
  for (  String pw : invalid) {
    try {
      pwAction.onPasswordChange(user,pw,root,NamePathMapper.DEFAULT);
      fail("should throw constraint violation");
    }
 catch (    ConstraintViolationException e) {
    }
  }
  List<String> valid=new ArrayList<String>();
  valid.add("abCDefGH");
  valid.add("Abbbbbbbbbbbb");
  valid.add("cDDDDDDDDDDDDDDDDD");
  valid.add("gH%%%%%%%%%%%%%%%%^^");
  valid.add("&)(*&^%23qW");
  for (  String pw : valid) {
    pwAction.onPasswordChange(user,pw,root,NamePathMapper.DEFAULT);
  }
}
