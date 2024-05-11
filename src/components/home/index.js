import React, { useState} from "react";
import { View, Text, TouchableOpacity} from "react-native";

import { useNavigation } from "@react-navigation/native";

import styles from './style';

export default function Home(){
    //função usada em botões para trocar de tela
    const navigation = useNavigation();
    //const [textButton, setTextButton] = useState("Acessar");


    return(
        <View>
            <View>
                <Text style={styles.textTitle}>pagina HOME</Text>
                    <TouchableOpacity
                    style={styles.buttonAcessar}
                    onPress={() => navigation.navigate("Main")}
                    >
                        <Text style={styles.textButtonAcessar}>Volta pagina Login</Text>
                    </TouchableOpacity>

                    <TouchableOpacity
                    style={styles.buttonAcessar}
                    onPress={() => navigation.navigate("MenuConfig")}
                    >
                        <Text style={styles.textButtonAcessar}>Menu configuração</Text>
                    </TouchableOpacity>

                    <TouchableOpacity
                    style={styles.buttonAcessar}
                    onPress={() => navigation.navigate("Carteira")}
                    >
                        <Text style={styles.textButtonAcessar}>Mostra carteira de vacina na pag Home</Text>
                    </TouchableOpacity>

                    <TouchableOpacity
                    style={styles.buttonAcessar}
                    onPress={() => navigation.navigate("CarteiraCadastro")}
                    >
                        <Text style={styles.textButtonAcessar}>Cadastrar Carteira de vacinação</Text>
                    </TouchableOpacity>

            </View>
        </View>
        
    )


}