@Test public void jndiLocationFound(){
  this.condition.setFoundLocation("java:/b");
  ConditionOutcome outcome=this.condition.getMatchOutcome(null,mockMetaData("java:/a","java:/b"));
  assertThat(outcome.isMatch(),equalTo(true));
}
