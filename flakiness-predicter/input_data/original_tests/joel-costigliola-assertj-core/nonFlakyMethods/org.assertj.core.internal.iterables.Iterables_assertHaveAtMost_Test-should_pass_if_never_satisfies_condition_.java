@Test public void should_pass_if_never_satisfies_condition_(){
  actual=newArrayList("Chewbacca","Leia","Obiwan");
  iterables.assertHaveAtMost(someInfo(),actual,2,jediPower);
  verify(conditions).assertIsNotNull(jediPower);
}
