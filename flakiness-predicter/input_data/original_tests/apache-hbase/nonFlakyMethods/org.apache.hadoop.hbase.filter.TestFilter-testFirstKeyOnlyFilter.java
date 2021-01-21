public void testFirstKeyOnlyFilter() throws IOException {
  Scan s=new Scan();
  s.setFilter(new FirstKeyOnlyFilter());
  KeyValue[] kvs={new KeyValue(ROWS_ONE[0],FAMILIES[0],QUALIFIERS_ONE[0],VALUES[0]),new KeyValue(ROWS_ONE[2],FAMILIES[0],QUALIFIERS_ONE[0],VALUES[0]),new KeyValue(ROWS_ONE[3],FAMILIES[0],QUALIFIERS_ONE[0],VALUES[0]),new KeyValue(ROWS_TWO[0],FAMILIES[0],QUALIFIERS_TWO[0],VALUES[1]),new KeyValue(ROWS_TWO[2],FAMILIES[0],QUALIFIERS_TWO[0],VALUES[1]),new KeyValue(ROWS_TWO[3],FAMILIES[0],QUALIFIERS_TWO[0],VALUES[1])};
  verifyScanFull(s,kvs);
}
