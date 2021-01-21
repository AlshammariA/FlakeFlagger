@Test public void should_pass_if_actual_not_has_same_type_as_other(){
  AssertionInfo info=someInfo();
  try {
    objects.assertHasSameClassAs(info,actual,"Yoda");
    failBecauseExpectedAssertionErrorWasNotThrown();
  }
 catch (  AssertionError err) {
    verify(failures).failure(info,shouldHaveSameClass(actual,"Yoda"));
  }
}
