@Test public void should_fail_when_some_field_values_differ(){
  AssertionInfo info=someInfo();
  Jedi actual=new Jedi("Yoda","Green");
  Jedi other=new Jedi("Yoda","Blue");
  try {
    objects.assertIsEqualToIgnoringGivenFields(info,actual,other,"name");
  }
 catch (  AssertionError err) {
    verify(failures).failure(info,shouldBeEqualToIgnoringGivenFields(actual,newArrayList("lightSaberColor"),newArrayList((Object)"Green"),newArrayList((Object)"Blue"),newArrayList("name")));
    return;
  }
  failBecauseExpectedAssertionErrorWasNotThrown();
}
