@Test public void all_assertions_should_pass(){
  softly.then(1).isEqualTo(1);
  softly.then(Lists.newArrayList(1,2)).containsOnly(1,2);
  softly.assertAll();
}
