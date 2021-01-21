@Test public void testEDIFACTEncodation(){
  String visualized=encodeHighLevel(".A.C1.3.DATA.123DATA.123DATA");
  assertEquals("240 184 27 131 198 236 238 16 21 1 187 28 179 16 21 1 187 28 179 16 21 1",visualized);
  visualized=encodeHighLevel(".A.C1.3.X.X2..");
  assertEquals("240 184 27 131 198 236 238 98 230 50 47 47",visualized);
  visualized=encodeHighLevel(".A.C1.3.X.X2.");
  assertEquals("240 184 27 131 198 236 238 98 230 50 47 129",visualized);
  visualized=encodeHighLevel(".A.C1.3.X.X2");
  assertEquals("240 184 27 131 198 236 238 98 230 50",visualized);
  visualized=encodeHighLevel(".A.C1.3.X.X");
  assertEquals("240 184 27 131 198 236 238 98 230 31",visualized);
  visualized=encodeHighLevel(".A.C1.3.X.");
  assertEquals("240 184 27 131 198 236 238 98 231 192",visualized);
  visualized=encodeHighLevel(".A.C1.3.X");
  assertEquals("240 184 27 131 198 236 238 89",visualized);
  visualized=encodeHighLevel(".XXX.XXX.XXX.XXX.XXX.XXX.üXX.XXX.XXX.XXX.XXX.XXX.XXX");
  assertEquals("240 185 134 24 185 134 24 185 134 24 185 134 24 185 134 24 185 134 24" + " 124 47 235 125 240" + " 97 139 152 97 139 152 97 139 152 97 139 152 97 139 152 97 139 152 89 89",visualized);
}
