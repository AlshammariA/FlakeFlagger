@Test public void jackrabbit_standalone(){
  String r=OptionHelper.substVars("${jackrabbit.log:-${repo:-jackrabbit}/log/jackrabbit.log}",context);
  assertEquals("jackrabbit/log/jackrabbit.log",r);
}
