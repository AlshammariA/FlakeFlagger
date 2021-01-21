@Test public void should_fail_when_some_actual_field_is_null_but_not_other(){
  AssertionInfo info=someInfo();
  Jedi actual=new Jedi("Yoda",null);
  Jedi other=new Jedi("Yoda","Green");
  try {
    objects.assertIsLenientEqualsToIgnoringNullFields(info,actual,other);
  }
 catch (  AssertionError err) {
    verify(failures).failure(info,shouldBeEqualToIgnoringGivenFields(actual,newArrayList("lightSaberColor"),newArrayList((Object)null),newArrayList((Object)"Green"),newArrayList("strangeNotReadablePrivateField")));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
