@Test public void all_assertions_should_pass(){
  softly.assertThat(1).isEqualTo(1);
  softly.assertThat(Lists.newArrayList(1,2)).containsOnly(1,2);
  softly.assertAll();
}
