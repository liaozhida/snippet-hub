

<snippet>
	<content><![CDATA[


import BeautifulSoup

page = BeautifulSoup(response.text, 'lxml')
captcha_id = page.find('input', attrs={'name':'captcha-id'})['value'] 
imageurl = page.find('img', alt='captcha')['src']

	
]]></content>
	<tabTrigger>net-parse-xml</tabTrigger>
	<scope>source.python</scope>
</snippet>

	
net-parse-xml.sublime-snippet