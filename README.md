# sublime-snippet

sublime的代码片段工具

1. 安装(OSX + sublime text 2)
	
	```
	cd ~/Library/Application\ Support/Sublime\ Text\ 2/Packages/User
	git clone http://gitlab.umiit.cn/tool/sublime-snippet.git
	```

2. 更新

	```
	cd ~/Library/Application\ Support/Sublime\ Text\ 2/Packages/User/sublime-snippet
	git pull
	```

3. 使用

	进入相关的文件，注意sublime右下角的文件内容必须为(javascript、html)，输入快捷键,然后按tab键(或者回车)即可。

4. 如何定义一个snippet

	```
	文件名必须以.sublime-snippet结尾，该文件为kraken-route-get-render.sublime-snippet
	<snippet>
		<content><![CDATA[ //内容定义在下方，${1}代表鼠标停留的第一个文字，当按tab键将切换到第2个位置，就是${2}
		router.get('/${1}', ${2} function(req, res) {
			var _q = req.query || {};
			var _p = req.params || {};
			${4}
			res.render('${3}');
		});
		]]></content>
		<tabTrigger>rgr</tabTrigger> //定义的快捷键，请不要重复，定义的规则通常是文件名每个单词首字母
		<scope>source.js</scope> //如果是js,填写source.js 如果是html,填写text.html.basic
	</snippet>
	```

5. 当你也想添加自己的snippet的时候
	* 你可以在该项目的 [Issues](http://gitlab.umiit.cn/tool/sublime-snippet/issues) 中new issues,写清楚相关需求
	* 将该项目clone到本地，然后新建一个分支，分支名为[issues的编号-snippet的名称]，然后编写代码，将该分支推送到服务器
	* 等待合并到master中