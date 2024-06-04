import { createContext, useState } from "react";
import { useNavigation } from "@react-navigation/native";
import { Alert } from "react-native";

import blogFetch from "../axios/config";

export const AuthContext = createContext({})

function AuthProvider({children}){

    const navigation = useNavigation();
    const [idToken, setIdToken] = useState();
    const [idCadastro, setIdcadastro] = useState();
    const [nome, setNome] = useState();

    const loginErrado = () => Alert.alert(
        "Oops!",
        "Email ou senha errado"
    );

    //buscando na api e criando um idtoken para criar sessao
    async function logIn(email, senha){
        try {
            const response = await blogFetch.get(`/conta/${email}/${senha}`);
            const data = response.data;
            const token = `${data}`;// transformando o numero recebido em string
            setIdToken(token);
            logar();
        } catch (error) {
            console.log(error);//mostra o erro que deu, provavelmente nao encontrou no back, apagar depois
            setIdToken();
            loginErrado(); 
        }       
    }

    function logar(){
        if(idToken == ""){
            loginErrado(); 
        }else{
            navigation.navigate("Home");
        }
    }

    function logOut(){
        setIdToken();
        navigation.navigate("Main");
    }

    return(
        <AuthContext.Provider value={{ idToken, idCadastro, nome, logIn, logOut, setIdcadastro, setNome }}>
            {children}
        </AuthContext.Provider>
    )
}

export default AuthProvider;
