
##
## EPITECH PROJECT, 2020
## makefile exe
## File description:
## fct
##

PACKAGE = transfer/src/re/fazan/transfer

SRC = $(PACKAGE)/Main.java		\
	$(PACKAGE)/ArgsTransfer.java

CLASSDIR = class

METAINF = META-INF/MANIFEST.MF

JARNAME	= 107transfer.jar 

EXENAME	= exec.sh

NAME = 107transfer

all: buildjar $(NAME)

buildjar:
	mkdir $(CLASSDIR)
	javac -d $(CLASSDIR) $(SRC)
	jar cfm $(JARNAME) $(METAINF) -C $(CLASSDIR) re

$(NAME):
	cp $(EXENAME) $(NAME)
	chmod +x $(NAME)

clean:
	rm -rf $(CLASSDIR)
	rm -f $(JARNAME)

fclean: clean
	rm -f $(NAME)

re:	fclean all
