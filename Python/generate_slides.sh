if [ $# -eq 0 ]
then
  echo "Usage: $0 lista_de_ficheiros"
  echo "e.g.,"
  echo "    $0 POO-jupyter/*.ipynb"
fi

for f in $*
do
  echo $f
  jupyter-nbconvert $f --to slides # --post serve
done