@Test public void should_group_bytes_in_short() throws Exception {
  String literals=NumberGrouping.toBinaryLiteral("1000000000000011");
  assertThat(literals).isEqualTo("10000000_00000011");
}
