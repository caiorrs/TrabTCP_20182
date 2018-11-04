# Trabalho TCP 2018/1

Reprodução de sons/notas musicais a partir de uma entrada de texto

## Getting Started

Instale o Eclipse for Java EE Developers

Instale o add-on Window Builder no eclipse

```
http://download.eclipse.org/windowbuilder/lastgoodbuild/
```

### Trabalhando no projeto

Na área superior direita da tela deve ter dois ícones, um deles indicando Java (passe o mouse em cima) e outro indicando Open Perspective
Clique em Open Perspective, escolha Git e clique em Open.

Crie sua branch pelo repo no github, só clique em branch e digite um nome inexistente para criá-la

Abra a pesrpectiva Git clicando nela (na área superior direita do eclipse).
Devem aparecer 3 opções na lateral esquerda, escolha Clone existing repository (ou algo assim)
Link do repositório

```
https://github.com/caiorrs/TrabTCP_20182.git
```

!!Escolha apenas sua branch para fazer clone!!

O eclipse deve ter importado o projeto para o workspace e deve ter salvo ele em seu_usuario/git/TrabTCP_20182 a menos que você tenha alterado.

Agora vá para a pespectiva Java, o projeto deve estar lá.

## Como fazer commits

os arquivos que você alterou podem ou não estar no commit, no eclipse você pode escolher. Vá na perspectiva Git e selecione Git Staging
na área inferior direita do eclipse. Escolha os arquivos que deseja incluir no commit (selecione múltiplos com CTRL + Botão direito do mouse) e clique no ícone "+" (Add selected files to the index)
após selecionar os arquivos necessários, escreva na primeira linha do commit (à direita da selecção dos arquivos) um nome curto que identifique as alterações
a partir da segunda linha detalhe o que foi feito.

Boas Práticas, faça commits pequenos e com poucas alterações.

Após isso clique em Commit

Quando quiser mandar essas alterações para a sua branch, ainda na perspectiva Git clique com o botão direito em Trabalho_TCP_2018[sua_branch] em Git Repositories
Clique em
```
Push Branch 'sua_branch'
```

Agora sua branch local e remota estão sincronizadas, se quiser, confira aqui no repo.

Para fazer o inverso (sincronizar sua branch local a partir da remota - USE SOMENTE SE TIVER CRIADO ALGUM ARQUIVO OU ALTERADO ALGO ONLINE)
na perspectiva Git clique com o botão direito em Trabalho_TCP_2018[sua_branch] em Git Repositories
Clique em
```
Fetch From Upstream
```

CUIDADO fetch irá sobrescrever seus arquivos locais com os arquivos remotos

- local = sua maquina
- remoto = repo aqui no github

INSTRUÇÕES WINDOW BUILDER

http://www.ntu.edu.sg/home/ehchua/programming/howto/EclipseJava_HowTo.html#GUIBuider
