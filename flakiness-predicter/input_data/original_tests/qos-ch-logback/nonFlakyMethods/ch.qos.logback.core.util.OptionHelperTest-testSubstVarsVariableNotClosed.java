@Test public void testSubstVarsVariableNotClosed(){
  String noSubst="testing if ${v1 works";
  try {
    @SuppressWarnings("unused") String result=OptionHelper.substVars(noSubst,context);
    fail();
  }
 catch (  IllegalArgumentException e) {
  }
}
