import React, { useState} from "react";
import { View, Text, TouchableOpacity} from "react-native";

import { useNavigation } from "@react-navigation/native";

import styles from './style';

export default function RedefiniSenha(){
    //função usada em botões para trocar de tela
    const navigation = useNavigation();
    //const [textButton, setTextButton] = useState("Acessar");


    return(
        <View>
            <View>
                <Text style={styles.textTitle}>pagina Redefinir Senha</Text>

                    <TouchableOpacity
                    style={styles.buttonAcessar}
                    onPress={() => navigation.navigate("Main")}
                    >
                        <Text style={styles.textButtonAcessar}>Volta pagina Login</Text>
                    </TouchableOpacity>   

                    <TouchableOpacity
                    style={styles.buttonAcessar}
                    onPress={() => navigation.navigate("Main")}
                    >
                        <Text style={styles.textButtonAcessar}>Confimar - pag. voltar pra o Login</Text>
                    </TouchableOpacity>           

            </View>
        </View>
        
    )


}